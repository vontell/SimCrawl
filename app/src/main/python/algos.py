from SimmonsSearch import graph as graph

# print graph

def DFS(start,end):
	if(start == end):
		return start
	agenda = [[start]]
	visited = set([])
	while(len(agenda) > 0):
		current_path = agenda.pop()
		if(current_path[-1] == end):
			return current_path
		current_node = current_path[-1]
		print current_node
		
		visited.add(current_node)
		neighbors = graph[current_node]
		neighbors = map(lambda x: x[0],neighbors)
		for node in neighbors:
			if node not in visited:
				agenda.append(current_path + [node])

# print DFS('5B','6B') <- hilarity

def BFS(start,end):
	if(start == end):
		return start
	agenda = [[start]]
	visited = set([])
	while(len(agenda) > 0):
		current_path = agenda.pop(0)
		if(current_path[-1] == end):
			return current_path
		current_node = current_path[-1]
		print current_node
		
		visited.add(current_node)
		neighbors = graph[current_node]
		neighbors = map(lambda x: x[0],neighbors)
		for node in neighbors:
			if node not in visited:
				agenda.append(current_path + [node])

# print BFS('5B','6B') <- much better