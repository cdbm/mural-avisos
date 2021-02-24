package com.cdbm.restavisos;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class NoticeController {
    private final NoticeRepository repository;

    NoticeController(NoticeRepository repository){
        this.repository = repository;
    }


    @CrossOrigin
    @GetMapping("/notices")
    List<Notice> getNotices(){
        return repository.findAll();
    }

    @PostMapping("/notices")
    Notice newNotice(@RequestBody Notice newNotice){
        return repository.save(newNotice);
    }

    @GetMapping("/notices/{id}")
    Notice one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NoticeNotFoundException(id));
    }

    @PutMapping("/notices/{id}")
    Notice replaceNotice(@RequestBody Notice newNotice, @PathVariable Long id) {

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

    @DeleteMapping("/notices/{id}")
    void deleteNotice(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
