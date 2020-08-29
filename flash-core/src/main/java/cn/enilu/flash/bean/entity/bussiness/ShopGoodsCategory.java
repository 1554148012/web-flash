package cn.enilu.flash.bean.entity.bussiness;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "shop_goods_category")
@Table(appliesTo = "shop_goods_category", comment = "分类")
@Data
@EntityListeners(AuditingEntityListener.class)
public class ShopGoodsCategory  implements Serializable {
    @Column(columnDefinition = "VARCHAR(32) COMMENT 'id主键'")
    @Id
    private String id;
    @Column(columnDefinition = "VARCHAR(100) COMMENT '分类名称'")
    private String categoryName;
    @Column(columnDefinition = "VARCHAR(6) COMMENT '分类编号'")
    private String categoryCode;
    @Column(columnDefinition = "VARCHAR(100) COMMENT '分类全编号'")
    private String categoryAllCode;
    @Column(columnDefinition = "INT COMMENT '级别'")
    private Integer level;
    @Column(columnDefinition = "VARCHAR(200) COMMENT '图片地址'")
    private String categoryImg;
    @Column(columnDefinition = "VARCHAR(32) COMMENT '父级编号'")
    private String parentCode;
    @Column(columnDefinition = "INT COMMENT '序号'")
    private Integer sort;
    @Column(columnDefinition = "INT COMMENT '子项总数'")
    private Integer subcount;


}