from SimmonsSearch import graph as graph
from mapping import map_room as map_room
# print graph

def DFS(start,end):
	start_room = start
	end_room = end
	if(start == end):
		return start

	if start not in graph:
		start = map_room(start)
	if end not in graph:
		end = map_room(end)

	agenda = [[start]]
	visited = set([])
	while(len(agenda) > 0):
		current_path = agenda.pop()
		if(current_path[-1] == end):
			current_path.pop(0)
			current_path.pop(len(current_path)-1)
			current_path.insert(0,start_room)
			current_path.append(end_room)
			return current_path
		current_node = current_path[-1]
		# print current_node
		
		visited.add(current_node)
		neighbors = graph[current_node]
		neighbors = map(lambda x: x[0],neighbors)
		for node in neighbors:
			if node not in visited:
				agenda.append(current_path + [node])



# print DFS('5B','6B') <- hilarity
# print DFS('377','673') <- more hilarity

def BFS(start,end):
	start_room = start
	end_room = end
	if(start == end):
		return start

	if start not in graph:
		start = map_room(start)
	if end not in graph:
		end = map_room(end)
	
	agenda = [[start]]
	visited = set([])
	while(len(agenda) > 0):
		current_path = agenda.pop(0)
		if(current_path[-1] == end):
			current_path.pop(0)
			current_path.pop(len(current_path)-1)
			current_path.insert(0,start_room)
			current_path.append(end_room)
			return current_path

		current_node = current_path[-1]
		# print current_node
		
		visited.add(current_node)
		neighbors = graph[current_node]
		neighbors = map(lambda x: x[0],neighbors)
		for node in neighbors:
			if node not in visited:
				agenda.append(current_path + [node])

# print BFS('5B','6B') <- much better
# print BFS('377','673') <- much better

def Dijkstra(start,end):
	
	start_room = start
	end_room = end
	if(start == end):
		return start

	if start not in graph:
		start = map_room(start)
	if end not in graph:
		end = map_room(end)

	prev = {}
	visited = set([])
	# queue = []
	distances = {}
	for node in graph:
		if(node == start):
			# queue.append((node,0))
			distances[node] = 0
		else:
			# queue.append((node,float('inf')))
			distances[node] = float('inf')

	while(len(distances.keys()) > 0):
		# queue = sorted(queue,key=lambda x: x[1])
		current_node = ''
		best_distance = float('inf')
		for node in distances:
			if distances[node] < best_distance:
				best_distance = distances[node]
				current_node = node

		del distances[current_node]

		# (current_node,distance) = queue.pop(0)
		visited.add(current_node)
		if(current_node == end):
			break
		neighbors = graph[current_node]
		for tup in neighbors:
			if tup[0] not in visited:
				cost = best_distance + tup[1]
				if cost < distances[tup[0]]:
					distances[tup[0]] = cost
					prev[tup[0]] = current_node

	route = []
	while(end != start):
		route.insert(0,end)
		end = prev[end]
	route.insert(0,start)
	route.pop(0)
	route.pop(len(route)-1)
	route.insert(0,start_room)
	route.append(end_room)
	return route

# print Dijkstra("Dining","MPR")
# print Dijkstra('422C','1022C')