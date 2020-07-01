package com.cevenant.backend.data.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService implements OrganizationRepo {
    @Autowired
    final private OrganizationRepo organizationRepo;

    public OrganizationService(OrganizationRepo organizationRepo) {
        this.organizationRepo = organizationRepo;
    }

    @Override
    public List<Organization> findAll() {
        return null;
    }

    @Override
    public List<Organization> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Organization> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Organization> findAllById(Iterable<Long> iterable) {
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
    public void delete(Organization organization) {

    }

    @Override
    public void deleteAll(Iterable<? extends Organization> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Organization> S save(S s) {
        return null;
    }

    @Override
    public <S extends Organization> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Organization> findById(Long aLong) {
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
    public <S extends Organization> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Organization> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Organization getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Organization> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Organization> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Organization> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Organization> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Organization> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Organization> boolean exists(Example<S> example) {
        return false;
    }
}
