package ${configuration.packageName};

import be.fpssocsec.person.TimeModificationInfo;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.apache.commons.collections4.Predicate;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class))
@Entity
@Table(name = "${configuration.entity.table.name}")
public class ${configuration.entity.name} {


<#list configuration.entity.table.tableFields as tableField>
    <#if tableField.id == true>
    @Id
    </#if>
    <#if tableField.colunm??>
    @Column(name = "${tableField.column}")
    <#else>
    @Column(name = "${tableField.name}")
    </#if>
    private ${tableField.type} ${tableField.name};
</#list>
}