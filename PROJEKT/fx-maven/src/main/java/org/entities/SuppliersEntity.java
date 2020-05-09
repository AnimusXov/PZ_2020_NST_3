package org.entities;

import javax.persistence.*;

@Entity
@Table(name = "suppliers", schema = "public", catalog = "Firma")
public class SuppliersEntity {
    private Integer supplierId;
    private String companyName;

    @Id
    @Column(name = "supplier_id", nullable = false)
    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "company_name", nullable = false, length = -1)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuppliersEntity that = (SuppliersEntity) o;

        if (supplierId != null ? !supplierId.equals(that.supplierId) : that.supplierId != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = supplierId != null ? supplierId.hashCode() : 0;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        return result;
    }
}
