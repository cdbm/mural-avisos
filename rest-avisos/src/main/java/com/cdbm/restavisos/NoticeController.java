package com.cdbm.restavisos;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoticeController {
    private final NoticeRepository repository;

    NoticeController(NoticeRepository repository){
        this.repository = repository;
    }


    @CrossOrigin
    @GetMapping("/notices")
    Page<Notice> getNotices(@PageableDefault(page=0, size=10)
                            @SortDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable){

        return repository.findAll(pageable);
    }

    @CrossOrigin
    @PostMapping("/notices")
    Notice newNotice(@RequestBody Notice newNotice){ return repository.save(newNotice); }

    @CrossOrigin
    @GetMapping("/notices/{id}")
    Notice one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NoticeNotFoundException(id));
    }

    @CrossOrigin
    @PutMapping("/notices/{id}")
    Notice replaceNotice(@RequestBody Notice newNotice, @PathVariable Long id) {
        System.out.println("entered");
        return repository.findById(id)
                .map(notice -> {
                    notice.setTitle(newNotice.getTitle());
                    notice.setDescription(newNotice.getDescription());
                    notice.setSeenAt(newNotice.getSeenAt());
                    notice.setCreatedAt(newNotice.getCreatedAt());
                    return repository.save(notice);
                })
                .orElseGet(() -> {
                    newNotice.setId(id);
                    return repository.save(newNotice);
                });
    }

    @CrossOrigin
    @DeleteMapping("/notices/{id}")
    void deleteNotice(@PathVariable Long id) {
        System.out.println("deleted");
        repository.deleteById(id);
    }

}
