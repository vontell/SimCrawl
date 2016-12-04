class Event:
	def __init__(self,title,host,room,section,dorm_event,start,end,t,count,i):
		self.title = title
		self.host = host
		self.room = room
		self.section = section
		self.dorm_event = dorm_event
		self.start = start
		self.end = end
		self.type = t
		self.count = count
		self.id = i
	
	def get_dict(self):
		return {
			"title":self.title,
			"host":self.host,
			"room":self.room,
			"section":self.section,
			"dormEvent":self.dorm_event,
			"start":self.start,
			"end":self.end,
			"type":self.type,
			"count":self.count,
			"id":self.id
		}	