package com.optimagrowth.organization.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.optimagrowth.organization.model.Organization;
import com.optimagrowth.organization.service.OrganizationService;

@Data
@RestController
@RequestMapping(value="v1/organization")
public class OrganizationController {
   // @Autowired
    private OrganizationService service;

    @GetMapping(value="/{organizationId}")
    public ResponseEntity<Organization> getOrganization( @PathVariable("organizationId") String organizationId) {
        return ResponseEntity.ok(service.findById(organizationId));
    }

    @PutMapping(value="/{organizationId}")
    public void updateOrganization( @PathVariable("organizationId") String id, @RequestBody Organization organization) {
        service.update(organization);
    }

    @PostMapping
    public ResponseEntity<Organization>  saveOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(service.create(organization));
    }

    @DeleteMapping(value="/{organizationId}")
   // @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable("organizationId") String organizationId) { //,  @RequestBody Organization organization) {
        service.delete(organizationId);
    }

}