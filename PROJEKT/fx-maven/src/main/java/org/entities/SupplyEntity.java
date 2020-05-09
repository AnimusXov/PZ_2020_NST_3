package org.entities;

import javax.persistence.*;

@Entity
@Table(name = "supply", schema = "public", catalog = "Firma")
public class SupplyEntity {
    private Integer supplyId;
    private Integer metallicMaterials;
    private Integer woodenMaterials;
    private Integer composites;
    private Integer marble;
    private Integer stoneMaterials;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "supply_id", nullable = false)
    public Integer getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Integer supplyId) {
        this.supplyId = supplyId;
    }

    @Basic
    @Column(name = "metallic_materials", nullable = false)
    public Integer getMetallicMaterials() {
        return metallicMaterials;
    }

    public void setMetallicMaterials(Integer metallicMaterials) {
        this.metallicMaterials = metallicMaterials;
    }

    @Basic
    @Column(name = "wooden_materials", nullable = false)
    public Integer getWoodenMaterials() {
        return woodenMaterials;
    }

    public void setWoodenMaterials(Integer woodenMaterials) {
        this.woodenMaterials = woodenMaterials;
    }

    @Basic
    @Column(name = "composites", nullable = false)
    public Integer getComposites() {
        return composites;
    }

    public void setComposites(Integer composites) {
        this.composites = composites;
    }

    @Basic
    @Column(name = "marble", nullable = false)
    public Integer getMarble() {
        return marble;
    }

    public void setMarble(Integer marble) {
        this.marble = marble;
    }

    @Basic
    @Column(name = "stone_materials", nullable = false)
    public Integer getStoneMaterials() {
        return stoneMaterials;
    }

    public void setStoneMaterials(Integer stoneMaterials) {
        this.stoneMaterials = stoneMaterials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupplyEntity that = (SupplyEntity) o;

        if (supplyId != null ? !supplyId.equals(that.supplyId) : that.supplyId != null) return false;
        if (metallicMaterials != null ? !metallicMaterials.equals(that.metallicMaterials) : that.metallicMaterials != null)
            return false;
        if (woodenMaterials != null ? !woodenMaterials.equals(that.woodenMaterials) : that.woodenMaterials != null)
            return false;
        if (composites != null ? !composites.equals(that.composites) : that.composites != null) return false;
        if (marble != null ? !marble.equals(that.marble) : that.marble != null) return false;
        if (stoneMaterials != null ? !stoneMaterials.equals(that.stoneMaterials) : that.stoneMaterials != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = supplyId != null ? supplyId.hashCode() : 0;
        result = 31 * result + (metallicMaterials != null ? metallicMaterials.hashCode() : 0);
        result = 31 * result + (woodenMaterials != null ? woodenMaterials.hashCode() : 0);
        result = 31 * result + (composites != null ? composites.hashCode() : 0);
        result = 31 * result + (marble != null ? marble.hashCode() : 0);
        result = 31 * result + (stoneMaterials != null ? stoneMaterials.hashCode() : 0);
        return result;
    }
}
