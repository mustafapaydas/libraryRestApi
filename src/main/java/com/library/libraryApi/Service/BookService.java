package com.library.libraryApi.Service;

import com.library.libraryApi.DTO.BookDTO;
import com.library.libraryApi.Entity.Book;
import com.library.libraryApi.Logic.BookLogic;
import com.library.libraryApi.Mapper.BookMapper;
import com.library.libraryApi.core.AbstractLogic;
import com.library.libraryApi.core.AbstractMapper;
import com.library.libraryApi.core.AbstractService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookService extends AbstractService<Integer, BookDTO, Book> {
    @Autowired
    BookLogic bookLogic;

    BookMapper bookMapper = new BookMapper();
    @Override
    protected AbstractLogic<Integer, Book> getLogic() {
        return bookLogic;
    }

    @Override
    protected AbstractMapper<BookDTO, Book> getMapper() {
        return bookMapper;
    }


    @Override
    @PreAuthorize("hasAuthority('xxx')")
    public BookDTO create(BookDTO dto){

        return getMapper().toDTO(getLogic().create(getMapper().tooEntity(dto)));
    }

    @Override
//    @PreAuthorize("hasAnyAuthority('/admin')")

    @PreAuthorize("hasAuthority('dfgdfsgd')")
    public BookDTO findById(Integer integer) {

        return super.findById(integer);
    }
}
