package domain.citycrud;

import com.example.pathfinder.domain.citycrud.CityCrudFacade;
import com.example.pathfinder.domain.citycrud.NodeAndConnectionRepository;
import com.example.pathfinder.domain.citycrud.NodeService;
import com.example.pathfinder.domain.citycrud.Node;
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
        String newName = "Warsaw 2.0";
        Node updatedNode = facade.updateNodeName(node.getId(), newName);
        // then
        assertThat(updatedNode.getName()).isEqualTo(newName);
    }


}
