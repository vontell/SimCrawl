from flask import Flask
from flask import request
from algos import BFS
import json
app = Flask(__name__)

@app.route("/")
def hello():
    return "Hello World!"

@app.route('/api/rooms')

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

if __name__ == "__main__":
    app.run()