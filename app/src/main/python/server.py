from flask import Flask
from flask import request
from algos import BFS
from mapping import init
import json
app = Flask(__name__)

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

if __name__ == "__main__":
    app.run()