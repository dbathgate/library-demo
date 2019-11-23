package io.pivotal.librarydemo.dao

import io.pivotal.librarydemo.model.Library
import io.pivotal.librarydemo.model.Book
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
class StaticLibraryDao: LibraryDao {

    override fun getLibrary(): Mono<Library> {
        val l = Library("Drb Library", listOf(
                Book("Deploying to Kubernetes", "Drb", listOf("k8s", "cloud")),
                Book("TDD", "Drb", listOf("k8s", "cloud"))
        ))
        return Mono.just(l)
    }
}