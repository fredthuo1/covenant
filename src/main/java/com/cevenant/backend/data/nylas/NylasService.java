package com.cevenant.backend.data.nylas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NylasService implements NylasRepository {

    @Autowired
    final private NylasRepository nylasRepository;

    public NylasService(NylasRepository nylasRepository) {
        this.nylasRepository = nylasRepository;
    }

    @Override
    public List<Nylas> findAll() {
        return null;
    }

    @Override
    public List<Nylas> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Nylas> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Nylas> findAllById(Iterable<Long> iterable) {
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
    public void delete(Nylas nylas) {

    }

    @Override
    public void deleteAll(Iterable<? extends Nylas> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Nylas> S save(S s) {
        return null;
    }

    @Override
    public <S extends Nylas> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Nylas> findById(Long aLong) {
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
    public <S extends Nylas> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Nylas> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Nylas getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Nylas> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Nylas> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Nylas> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Nylas> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Nylas> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Nylas> boolean exists(Example<S> example) {
        return false;
    }
}
