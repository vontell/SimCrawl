from flask import Flask
from flask import request
from algos import BFS
from mapping import init
import json
from event import Event
app = Flask(__name__)

events = []

@app.route("/")
def hello():
    return "Hello World!"

@app.route('/api/search')
def search():
	start = request.args.get('start')
	end = request.args.get('end')
	route = BFS(start,end)
	# return route
	# js = [ { "name" : filename, "size" : st.st_size , 
        # "url" : url_for('show', filename=filename)} ]
	# return Response(json.dumps(js),  mimetype='application/json')
	# return Response(json.dumps(route), mimetype='application/json')
	return json.dumps(route)

@app.route('/api/rooms')
def room_dump():
	room_dict = init()
	# print room_dict
	for section in room_dict:
		room_dict[section] = list(room_dict[section])
	return json.dumps(room_dict)

@app.route('/api/events')
def event_dump():
	event_dicts = []
	for event in events:
		event_dicts.append(event.get_dict())
		
	return json.dumps(event_dicts)

@app.route('/api/event',methods=['POST'])
def create_event():
	global events
	print "here"
	data = request.data
	print data
	dataDict = json.loads(data)
	print dataDict
	# print request.form['title']
	# args = request.form
	args = dataDict
	e = Event(args['title'],args['host'],args['room'],args['section'],args['dormEvent'],args['start'],args['end'],args['type'],args['count'],len(events))
	events.append(e)
	# return json.dumps(events.get_dict())
	# print "here"
	return "Added event"

if __name__ == "__main__":
    app.run()