package com.library.libraryApi.Service;

import com.library.libraryApi.DTO.BookDTO;
import com.library.libraryApi.Entity.Book;
import com.library.libraryApi.Logic.BookLogic;
import com.library.libraryApi.Mapper.BookMapper;
import com.library.libraryApi.core.Abstract.AbstractLogic;
import com.library.libraryApi.core.Abstract.AbstractMapper;
import com.library.libraryApi.core.Abstract.AbstractService;
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
    protected AbstractMapper<Integer,BookDTO, Book> getMapper() {
        return bookMapper;
    }


    @Override
    @PreAuthorize("hasAuthority('SAVE_BOOK_RECORD')")
    public BookDTO create(BookDTO dto){
        return getMapper().toDTO(getLogic().create(getMapper().toEntity(dto)));
    }

    @Override
//    @PreAuthorize("hasAuthority('VIEW_BOOK_RECORD')")
    public BookDTO findById(Integer integer) {

        return super.findById(integer);
    }

    @Override
    @PreAuthorize("hasAuthority('DELETE_BOOK')")
    public void deleteById(Integer integer) {
        super.deleteById(integer);
    }
}
