package domain.citycrud;

class CityCrudFacade {

    private final NodeService nodeService;

    public CityCrudFacade(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    public Node addNode(Node node) {
        return nodeService.save(node);
    }
}
