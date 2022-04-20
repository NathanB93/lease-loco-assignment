package com.leaseloco.leaselocoassignment.batchprocessing;

import com.leaseloco.leaselocoassignment.POJOs.DealPOJO;
import com.leaseloco.leaselocoassignment.models.Deal;
import com.leaseloco.leaselocoassignment.repository.DealRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.persistence.EntityManagerFactory;
import java.io.IOException;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DealRepository dealRepository;

    @Autowired
    EntityManagerFactory emf;

    @Bean
    public DealItemProcessor processor() {
        return new DealItemProcessor();
    }


    @Bean
    public CustomFieldSetMapper customFieldSetMapper() {
        return new CustomFieldSetMapper();
    }


    @Bean
    public FlatFileItemReader<DealPOJO> myCustomReader() {
        FlatFileItemReader<DealPOJO> reader = new FlatFileItemReader<DealPOJO>();
        reader.setLinesToSkip(1);
        reader.setLineMapper(dealFileMapper());

        return reader;
    }

    @Bean
    public DelimitedLineTokenizer tokenizer(){
        return new DelimitedLineTokenizer();
    }

    @Bean
    public ItemReader<DealPOJO> reader() {

        Resource[] resources = null;
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        try {
            resources = patternResolver.getResources("input/*.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        MultiResourceItemReader<DealPOJO> reader = new MultiResourceItemReader<>();
        reader.setResources(resources);
        reader.setDelegate(myCustomReader());
        return reader;
    }


    @Bean
    public DefaultLineMapper dealFileMapper() {
        DefaultLineMapper lineMapper = new DefaultLineMapper();
        lineMapper.setLineTokenizer(tokenizer());
        lineMapper.setFieldSetMapper(customFieldSetMapper());

        return lineMapper;
    }

    @Bean
    public JpaItemWriter writer() {
        JpaItemWriter writer = new JpaItemWriter();
        writer.setEntityManagerFactory(emf);
        return writer;
    }

    @Bean
    public Job importDealJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<DealPOJO, Deal> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
}
