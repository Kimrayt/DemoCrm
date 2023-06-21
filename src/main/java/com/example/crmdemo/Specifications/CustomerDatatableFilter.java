package com.example.crmdemo.Specifications;

import com.example.crmdemo.Model.Customer;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;

public class CustomerDatatableFilter implements Specification<Customer> {
    String userQuery;
    public CustomerDatatableFilter(String queryString) {
        this.userQuery = queryString;
    }
    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        ArrayList<Predicate> predicates = new ArrayList<>();
        if (userQuery != null && !userQuery.equals("")) {
            predicates.add(criteriaBuilder.like(root.get("firstName"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("lastName"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("desiredCourse"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("emailAddress"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("phoneNumber"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("country"), '%' + userQuery + '%'));
        }
        return (!predicates.isEmpty()?criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()])):null);
    }
}