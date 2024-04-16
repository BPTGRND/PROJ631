class User:
    def __init__(self, id, interest_data_ids, accessible_node_id):
        self.id = id
        self.interest_data_ids = interest_data_ids
        self.accessible_node_id = accessible_node_id

    def get_id(self):
        return self.id

    def get_interest_data_ids(self):
        return self.interest_data_ids

    def get_accessible_node_id(self):
        return self.accessible_node_id

