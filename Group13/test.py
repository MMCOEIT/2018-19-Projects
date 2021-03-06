import cv2

cap = cv2.VideoCapture(0)


faceCascade = cv2.CascadeClassifier("haarcascade_frontalface_default.xml")

i=1

while(i<10):
	
	ret, frame = cap.read()

	
	gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

	
	faces = faceCascade.detectMultiScale(
		gray,
		scaleFactor=1.1,
		minNeighbors=5,
		minSize=(30, 30)
		#flags = cv2.CV_HAAR_SCALE_IMAGE
	)
	i=i+1

	print("Found {0} faces!".format(len(faces)))

	
	for (x, y, w, h) in faces:
		cv2.rectangle(frame, (x, y), (x+w, y+h), (0, 255, 0), 2)

	
	cv2.imshow('frame', frame)
	if cv2.waitKey(1) & 0xFF == ord('q'):
		break

cv2.waitKey(0)
