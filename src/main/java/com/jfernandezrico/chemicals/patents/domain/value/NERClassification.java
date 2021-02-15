package com.jfernandezrico.chemicals.patents.domain.value;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data @Builder public class NERClassification {

    private Set<String> persons;
    private Set<String> organizations;
    private Set<String> locations;

    public NERClassification union(NERClassification other) {
        if (other != null) {
            persons.addAll(other.getPersons());
            organizations.addAll(other.getOrganizations());
            locations.addAll(other.getLocations());
        }
        return this;
    }
}
