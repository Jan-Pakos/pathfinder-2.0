package domain.citycrud;

import com.example.pathfinder.citycrud.CityCrudFacade;
import com.example.pathfinder.citycrud.Node;
import com.example.pathfinder.citycrud.NodeAndConnectionRepository;
import com.example.pathfinder.citycrud.NodeService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CityCrudFacadeTest {


    private final NodeAndConnectionRepository inMemoryRepository = new NodeAndConnectionInMemoryRepository();
    private final NodeService nodeService = new NodeService(inMemoryRepository);
    private final CityCrudFacade facade = new CityCrudFacade(nodeService);

    @Test
    void should_add_node() {
        // given
        Node warsaw = Node.builder()
                .id(1L)
                .name("Warsaw")
                .build();
        // when
        Node node = facade.addNode(warsaw);
        // then
        assertThat(node).isNotNull();
        assertThat(node.getId()).isEqualTo(warsaw.getId());
    }

    @Test
    void should_remove_node() {
        // given
        Node warsaw = Node.builder()
                .id(1L)
                .name("Warsaw")
                .build();

        Node node = facade.addNode(warsaw);
        // when
        facade.removeNode(node.getId());
        // then
        assertThat(inMemoryRepository.findById(node.getId())).isEmpty();
    }

    @Test
    void should_update_node_name() {
        // given
        Node warsaw = Node.builder()
                .id(1L)
                .name("Warsaw")
                .build();

        Node node = facade.addNode(warsaw);
        // when
        facade.updateNodeName(node.getId(), "Warsaw 2.0");
        // then
        assertThat(node.getName()).isEqualTo("Warsaw 2.0");
    }


}
