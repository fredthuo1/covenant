package com.cevenant.backend.data.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService implements EmailRepository {
    @Autowired
    final private EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public List<Email> findAll() {
        return null;
    }

    @Override
    public List<Email> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Email> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Email> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Email email) {

    }

    @Override
    public void deleteAll(Iterable<? extends Email> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Email> S save(S s) {
        return null;
    }

    @Override
    public <S extends Email> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Email> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Email> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Email> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Email getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Email> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Email> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Email> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Email> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Email> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Email> boolean exists(Example<S> example) {
        return false;
    }
}
