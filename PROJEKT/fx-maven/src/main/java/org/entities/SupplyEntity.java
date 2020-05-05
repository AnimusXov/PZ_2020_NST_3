package org.entities;

import javax.persistence.*;

@Entity
@Table(name = "supply", schema = "public", catalog = "Firma")
public class SupplyEntity {
    private int supplyId;
    private int metallicMaterials;
    private int woodenMaterials;
    private int composites;
    private int marble;
    private int stoneMaterials;

    @Id
    @Column(name = "supply_id", nullable = false)
    public int getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(int supplyId) {
        this.supplyId = supplyId;
    }

    @Basic
    @Column(name = "metallic_materials", nullable = false)
    public int getMetallicMaterials() {
        return metallicMaterials;
    }

    public void setMetallicMaterials(int metallicMaterials) {
        this.metallicMaterials = metallicMaterials;
    }

    @Basic
    @Column(name = "wooden_materials", nullable = false)
    public int getWoodenMaterials() {
        return woodenMaterials;
    }

    public void setWoodenMaterials(int woodenMaterials) {
        this.woodenMaterials = woodenMaterials;
    }

    @Basic
    @Column(name = "composites", nullable = false)
    public int getComposites() {
        return composites;
    }

    public void setComposites(int composites) {
        this.composites = composites;
    }

    @Basic
    @Column(name = "marble", nullable = false)
    public int getMarble() {
        return marble;
    }

    public void setMarble(int marble) {
        this.marble = marble;
    }

    @Basic
    @Column(name = "stone_materials", nullable = false)
    public int getStoneMaterials() {
        return stoneMaterials;
    }

    public void setStoneMaterials(int stoneMaterials) {
        this.stoneMaterials = stoneMaterials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupplyEntity that = (SupplyEntity) o;

        if (supplyId != that.supplyId) return false;
        if (metallicMaterials != that.metallicMaterials) return false;
        if (woodenMaterials != that.woodenMaterials) return false;
        if (composites != that.composites) return false;
        if (marble != that.marble) return false;
        if (stoneMaterials != that.stoneMaterials) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = supplyId;
        result = 31 * result + metallicMaterials;
        result = 31 * result + woodenMaterials;
        result = 31 * result + composites;
        result = 31 * result + marble;
        result = 31 * result + stoneMaterials;
        return result;
    }
}
