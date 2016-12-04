'''
ok so here are sections

2W: 2AB
4E: 3/4C
4W: 4AB
5C: 5AB
6E: 5/6C
6W: 6AB
8C: B Tower
8E: 7ABC
8W: A Tower
9E: C Tower
'''

# c_tower_set = set([975,1078B,1074,978,1078A,1040,940,1040,938,977,873,1077,1073,978,1075,980,840,939,874,840,941,940,939,875,1039,973,1078B,1039,839,878,1038,979,1076,974,1078B,941,980,840,878,976])
# two_ab_set = set([329,341,224A,225,252,322B,345,244B,344,327,321,252,244C,229,228,322B,329,321,344,326,328,344,324,324,228,322D,230,341,224B,326,329,326,328,224A,322C,225,322B,322C,225,330,325])

def init():

	files = ['a_tower_rooms.txt','7abc_rooms.txt','b_tower_rooms.txt','6ab_rooms.txt','56c_rooms.txt','4ab_rooms.txt','5ab_rooms.txt','34c_rooms.txt','c_tower_rooms.txt','2a_rooms.txt']

	a_tower_set = set([])
	b_tower_set = set([])
	c_tower_set = set([])

	two_ab_set = set([])
	three_four_c_set = set([])
	four_ab_set = set([])
	five_ab_set = set([])
	five_six_c_set = set([])
	six_ab_set = set([])
	seven_abc_set = set([])

	a_tower_rooms_file = open('a_tower_rooms.txt','r')

	for line in a_tower_rooms_file:
		line = line.strip()
		a_tower_set.add(line)

	a_tower_rooms_file.close()

	b_tower_rooms_file = open('b_tower_rooms.txt','r')

	for line in b_tower_rooms_file:
		line = line.strip()
		b_tower_set.add(line)

	b_tower_rooms_file.close()

	c_tower_rooms_file = open('c_tower_rooms.txt','r')

	for line in c_tower_rooms_file:
		line = line.strip()
		c_tower_set.add(line)

	c_tower_rooms_file.close()

	two_ab_rooms_file = open('2a_rooms.txt','r')

	for line in two_ab_rooms_file:
		line = line.strip()
		two_ab_set.add(line)

	two_ab_rooms_file.close()

	seven_abc_rooms_file = open('7abc_rooms.txt','r')

	for line in seven_abc_rooms_file:
		line = line.strip()
		seven_abc_set.add(line)

	seven_abc_rooms_file.close()

	six_ab_rooms_file = open('6ab_rooms.txt','r')

	for line in six_ab_rooms_file:
		line = line.strip()
		six_ab_set.add(line)

	six_ab_rooms_file.close()

	five_six_c_rooms_file = open('56c_rooms.txt','r')

	for line in five_six_c_rooms_file:
		line = line.strip()
		five_six_c_set.add(line)

	five_six_c_rooms_file.close()

	four_ab_rooms_file = open('4ab_rooms.txt','r')

	for line in four_ab_rooms_file:
		line = line.strip()
		four_ab_set.add(line)

	four_ab_rooms_file.close()

	five_ab_rooms_file = open('5ab_rooms.txt','r')

	for line in five_ab_rooms_file:
		line = line.strip()
		five_ab_set.add(line)

	five_ab_rooms_file.close()

	three_four_c_rooms_file = open('34c_rooms.txt','r')

	for line in three_four_c_rooms_file:
		line = line.strip()
		three_four_c_set.add(line)

	three_four_c_rooms_file.close()

	rooms_dictionary = {'A Tower':a_tower_set,
	'B Tower':b_tower_set,
	'C Tower':c_tower_set,

	'23AB':two_ab_set,
	'34C':three_four_c_set,
	'4AB':four_ab_set,
	'5AB':five_ab_set,
	'56C':five_six_c_set,
	'6AB':six_ab_set,
	'7ABC':seven_abc_set
	}
	# print rooms_dictionary
	return rooms_dictionary

# print rooms_set

def map_room(room_number):
	C_tower_indices = ['39','30','73','74','75','76','77','78A','78B','41']
	B_tower_indices = ['31','32','33','34','36','52A','64','65','66','72','71']
	rooms_dictionary = init()
	correct_section = ''
	for section in rooms_dictionary:
		if(room_number in rooms_dictionary[section]):
			correct_section = section
			break

	if('Tower' in correct_section):
		if(room_number[0] == '1'):
			return room_number[0:2] + correct_section[0]
		return room_number[0] + correct_section[0]
	elif('ABC' in correct_section):
		for index in C_tower_indices:
			if(index in room_number[1:]):
				return '7C'
		for index in B_tower_indices:
			if(index in room_number[1:]):
				return '7B'
		return '7A'
	elif('AB' in correct_section):
		for index in B_tower_indices:
			if(index in room_number[1:]):
				return room_number[0] + 'B'
		return room_number[0] + 'A'
	else:
		return room_number[0] + 'C'


# print(map_room('673'))