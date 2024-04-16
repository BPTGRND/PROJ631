class SystemNode:
    # CONSTRUCTOR
    def __init__(self, id, memory_capacity, accessible_node_ids):
        self.id = id
        self.memory_capacity = memory_capacity
        self.local_data_ids = []
        self.accessible_node_ids = accessible_node_ids

    # GETTERS
    def get_id(self):
        return self.id

    def get_memory_capacity(self):
        return self.memory_capacity

    def get_accessible_node_ids(self):
        return self.accessible_node_ids

    def get_local_data_ids(self):
        return self.local_data_ids

    # FUNCTION THAT APPENDS THE ID OF A DATA TO A NODE
    def add_local_data(self, local_data_id):
        self.local_data_ids.append(local_data_id)
