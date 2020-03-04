package com.hibernate.sql;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepositoryWithPage extends PagingAndSortingRepository<Note, Long> {
	Page<Note> findAll(Pageable pageable);

	Page<Note> findByTitle(String title, Pageable pageable);

	Slice<Note> findByTitleAndContent(String title, String content, Pageable pageable);
}
