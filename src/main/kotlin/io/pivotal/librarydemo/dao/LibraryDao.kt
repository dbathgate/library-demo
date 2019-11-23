package io.pivotal.librarydemo.dao

import io.pivotal.librarydemo.model.Library
import reactor.core.publisher.Mono

interface LibraryDao {
    fun getLibrary(): Mono<Library>
}