package edu.sakp.service;


import edu.sakp.pojo.Notice;

public interface NoticeService {
    void update(Notice notice);

    void add(Notice notice);

    void deleteById(Long id);

    Object getAllByLimit(Notice notice);

    Notice getById(Long id);

    void view(Long id);
}
