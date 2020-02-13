# Importing all necessary libraries
import cv2
import os
import sys

def main(video_path): #dancing.mp4

    # Read the video from specified path
    cam = cv2.VideoCapture("src/main/resources/video/" + video_path)

    try:
        # creating a folder named data
        if not os.path.exists('src/main/resources/images'):
            os.makedirs('src/main/resources/images')

    # if not created then raise error
    except OSError:
        print ('Error: Creating directory of data')

    # frame
    currentframe = 0

    while(True):

        # reading from frame
        ret,frame = cam.read()

        if ret:
            # if video is still left continue creating images
            name = 'src/main/resources/images/image-frame' + str(currentframe) + '.jpg'
            print ('Creating...' + name)

            # writing the extracted images
            cv2.imwrite(name, frame)

            # increasing counter so that it will
            # show how many frames are created
            currentframe += 1
        else:
            break

    # Release all space and windows once done
    cam.release()
    cv2.destroyAllWindows()


if __name__ == '__main__':
  main(sys.argv[1])

