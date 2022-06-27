package com.optimagrowth.organization.service;

import java.util.Optional;
import java.util.UUID;

import lombok.Data;

import org.springframework.stereotype.Service;

import com.optimagrowth.organization.model.Organization;
import com.optimagrowth.organization.repository.OrganizationRepository;

@Data
@Service
public class OrganizationService {

    private final OrganizationRepository repository;

    public Organization findById(String organizationId) {
        Optional<Organization> opt = repository.findById(organizationId);
        return (opt.isPresent()) ? opt.get() : null;
    }

    public Organization create(Organization organization) {
//        organization.setId(Long.valueOf(UUID.randomUUID().toString()));
        organization.setId(UUID.randomUUID().toString());
        organization = repository.save(organization);
        return organization;

    }

    public void update(String organizationId, Organization organization) {
        organization.setId(organizationId);
        repository.save(organization);
    }

    public void delete(String organizationId) {
        repository.deleteById(organizationId);
    }
}
