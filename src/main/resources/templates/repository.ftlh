package ${package};

import static java.util.stream.Collectors.toList;

import be.fpssocsec.restexception.ResourceNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("${name}")
public interface ${name}Repository
extends JpaRepository<${name}, Integer>,
JpaSpecificationExecutor<${name}> {

}