package org.sonatype.cs.metrics.service;

import java.util.List;

import org.sonatype.cs.metrics.model.DbRow;
import org.sonatype.cs.metrics.model.DbRowStr;
import org.sonatype.cs.metrics.model.Mttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataService  {
    @Autowired 
    private JdbcTemplate jtm;
    
    public void runSqlLoad(String stmt) {
        jtm.execute(stmt);
    }
      
    public List<DbRow> runSql(String stmt) {
        return jtm.query(stmt, new BeanPropertyRowMapper<>(DbRow.class));  
    }

    public List<DbRowStr> runSqlStr(String stmt) {
        return jtm.query(stmt, new BeanPropertyRowMapper<>(DbRowStr.class));  
    }

    public List<Mttr> runSqlMttr(String stmt) {
        return jtm.query(stmt, new BeanPropertyRowMapper<>(Mttr.class));  
    }
}
