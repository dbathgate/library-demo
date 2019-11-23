package io.pivotal.librarydemo.controller

import io.pivotal.librarydemo.dao.LibraryDao
import io.pivotal.librarydemo.model.Library
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/library")
class LibraryController(@Autowired val libraryDao: LibraryDao) {


    @GetMapping
    fun getLibrary(): Mono<Library> {
        return libraryDao.getLibrary();
    }
}