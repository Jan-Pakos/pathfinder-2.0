package domain.citycrud;

import com.example.pathfinder.domain.citycrud.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CityCrudFacadeTest {


    private final NodeRepository inMemoryRepository = new NodeAndConnectionInMemoryRepository();
    private final NodeService nodeService = new NodeService(inMemoryRepository);
    private final ConnectionService connectionService = new ConnectionService(new ConnectionInMemoryRepository());
    private final CityCrudFacade facade = new CityCrudFacade(nodeService, connectionService);

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

    @Test
    void should_add_connection_between_two_nodes() {
        // given
        Node warsaw = Node.builder()
                .id(1L)
                .name("Warsaw")
                .build();

        Node stockholm = Node.builder()
                .id(1L)
                .name("Stockholm")
                .build();

        Node addedWarsawNode = facade.addNode(warsaw);
        Node addedStockholmNode = facade.addNode(stockholm);
        // when
        Connection addedConnection = facade.addConnection(addedWarsawNode.getId(), addedStockholmNode.getId(), 100L, TransportType.TRAIN);
        // then
        assertThat(addedConnection.getFromNode().getId()).isEqualTo(addedWarsawNode.getId());
        assertThat(addedConnection.getToNode().getId()).isEqualTo(addedStockholmNode.getId());
    }

    @Test
    void should_throw_exception_when_adding_connection_that_already_exists() {
        // given
        Node warsaw = Node.builder()
                .id(1L)
                .name("Warsaw")
                .build();

        Node stockholm = Node.builder()
                .id(1L)
                .name("Stockholm")
                .build();

        Node addedWarsawNode = facade.addNode(warsaw);
        Node addedStockholmNode = facade.addNode(stockholm);

        Connection addedConnection = facade.addConnection(addedWarsawNode.getId(), addedStockholmNode.getId(), 100L, TransportType.TRAIN);
        // when

        Throwable exception = facade.addConnection(addedWarsawNode.getId(), addedStockholmNode.getId(), 100L, TransportType.TRAIN);
        // then
        assertThat(updatedNode.getName()).isEqualTo(newName);
    }


}
