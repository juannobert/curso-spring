package com.juannobert.animeapi.configurer;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class AnimeApiWebMvcConfigurer implements WebMvcConfigurer {
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		var pageable = new PageableHandlerMethodArgumentResolver();
		pageable.setFallbackPageable(PageRequest.of(0, 3));
		resolvers.add(pageable);
	}

}
