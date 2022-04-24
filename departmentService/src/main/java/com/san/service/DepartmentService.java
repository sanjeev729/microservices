package com.san.service;

import com.san.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.entity.Department;
import com.san.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Get department by Id");
        return departmentRepository.findById(departmentId).orElseThrow(() -> {
            throw new ResourceNotFoundException("Department Id does not exist");
        });

    }

    public List<Department> getAllDepartments() {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.findAll();
    }

    public Department deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> {
            throw new ResourceNotFoundException("Department Id does not exist");
        });
        log.info("Delete department by Id");
        departmentRepository.deleteById(departmentId);
        return department;

    }

    public Department updateDepartment(Long departmentId, Department department) {
        Department oldDepartment = departmentRepository.findById(departmentId).orElseThrow(() -> {
            throw new ResourceNotFoundException("Department Id does not exist");
        });
        oldDepartment.setDepartmentAddress(department.getDepartmentAddress());
        oldDepartment.setDepartmentCode(department.getDepartmentCode());
        oldDepartment.setDepartmentName(department.getDepartmentName());
        return departmentRepository.save(oldDepartment);
    }
}
