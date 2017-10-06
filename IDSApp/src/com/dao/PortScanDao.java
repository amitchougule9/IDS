package com.dao;

import java.util.List;

import com.entities.PortScan;

public interface PortScanDao {

    void createPortScanTable();

    void insert(PortScan portScan);

    PortScan selectById(int Id);

    List<PortScan> selectAll();

    void delete(int Id);

    void update(PortScan portScan, int Id);

}
