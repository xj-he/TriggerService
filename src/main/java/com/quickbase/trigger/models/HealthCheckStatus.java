package com.quickbase.trigger.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Defines the health check status domain model object used to serialize/de-serialize API requests
 * Created by mgreenwood on 2/10/16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(NON_NULL)
public class HealthCheckStatus implements Serializable {

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    protected Date sqlDate;

    public HealthCheckStatus() {
    }

    public HealthCheckStatus(HealthCheckStatus healthCheckStatus) {
        this.sqlDate = healthCheckStatus.getSqlDate();
    }


    public Date getSqlDate() {
        return sqlDate != null ? (Date)sqlDate.clone() : null;
    }

    public void setSqlDate(Date sqlDate) {
        this.sqlDate = sqlDate != null ? new Date(sqlDate.getTime()) : null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sqlDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final HealthCheckStatus other = (HealthCheckStatus) obj;
        return Objects.equals(this.sqlDate, other.sqlDate);
    }

    @Override
    public String toString() {
        return "HealthCheckStatus{" +
            "sqlDate=" + sqlDate +
            '}';
    }
}
