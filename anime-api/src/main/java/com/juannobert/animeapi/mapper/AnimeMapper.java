package com.juannobert.animeapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.juannobert.animeapi.domain.Anime;
import com.juannobert.animeapi.requests.AnimeRequest;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
	public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
	@Mapping(target = "id", ignore = true)
	public abstract Anime toAnime(AnimeRequest animeRequest);
}
