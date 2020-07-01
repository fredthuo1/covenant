package com.cevenant.backend.data.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationService implements DonationRepository {
    @Autowired
    final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public List<Donation> findAll() {
        return null;
    }

    @Override
    public List<Donation> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Donation> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Donation> findAllById(Iterable<Long> iterable) {
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
    public void delete(Donation donation) {

    }

    @Override
    public void deleteAll(Iterable<? extends Donation> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Donation> S save(S s) {
        return null;
    }

    @Override
    public <S extends Donation> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Donation> findById(Long aLong) {
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
    public <S extends Donation> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Donation> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Donation getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Donation> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Donation> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Donation> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Donation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Donation> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Donation> boolean exists(Example<S> example) {
        return false;
    }
}
