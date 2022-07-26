package br.com.agrotis.register.config;

import br.com.agrotis.register.domain.mapper.LaboratorioMapper;
import br.com.agrotis.register.domain.mapper.ProdutorMapper;
import br.com.agrotis.register.domain.mapper.PropriedadeMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Commons {

    @Bean
    public ProdutorMapper produtorMapper() {
        return new ProdutorMapper();
    }

    @Bean
    public LaboratorioMapper laboratorioMapper() {
        return new LaboratorioMapper();
    }

    @Bean
    public PropriedadeMapper propriedadeMapper() {
        return new PropriedadeMapper();
    }
}
