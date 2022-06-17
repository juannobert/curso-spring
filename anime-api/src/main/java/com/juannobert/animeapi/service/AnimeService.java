package com.juannobert.animeapi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.juannobert.animeapi.domain.Anime;
import com.juannobert.animeapi.exception.BadRequestException;
import com.juannobert.animeapi.mapper.AnimeMapper;
import com.juannobert.animeapi.repository.AnimeRepository;
import com.juannobert.animeapi.requests.AnimeRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimeService {
	
	private final AnimeRepository animeRepository;
	

	public Page<Anime> listAll(Pageable pageable) {
		return animeRepository.findAll(pageable);
	}
	public List<Anime> findByName(String name) {
		return animeRepository.findByName(name);
	}

	public Anime findById(long id) {
		return animeRepository
				.findById(id)
				.orElseThrow(() -> new BadRequestException("Animes not Found"));
	}

	public Anime save(AnimeRequest animeRequest) {
		Anime anime = AnimeMapper.INSTANCE.toAnime(animeRequest);
		return animeRepository.save(anime);
	}

	public void delete(long id) {
		Anime anime = animeRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Animes not Found"));
		animeRepository.delete(anime);
	}

	public void update(Long id, AnimeRequest animeRequest) {
		Anime animeFind = animeRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Animes not Found"));
		animeFind.setName(animeRequest.getName());
		animeRepository.save(animeFind);
		
	}

}
