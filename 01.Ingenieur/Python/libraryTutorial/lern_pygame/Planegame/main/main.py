import pygame

Screen_Width = 800
Screen_Height = 600
Screen_Title = "Planegame"
absolutePath = "/Users/myry/Documents/MyPythonProject/lernLibs/lern_pygame/Planegame/pngs/"


# initialize
pygame.init()
screen = pygame.display.set_mode((Screen_Width, Screen_Height)) #size
pygame.display.set_caption(Screen_Title) # title

icon = pygame.image.load(absolutePath + "ufo.png")
pygame.display.set_icon(icon) # icon

background = pygame.image.load(absolutePath + "bg.png")

plane = pygame.image.load(absolutePath + "player.png")

enemy = pygame.image.load(absolutePath + "enemy.png")

# Background
def drawBg(background):
    screen.blit(background, (0,0))


# Hero
def drawPlane(plane, x, y):
    screen.blit(plane, (x,y))

PlaneX = 400
PlaneY = 500
PlaneSpeed = 10


# Enemy
def drawEnemy(enemy, x, y):
    screen.blit(enemy, (x,y))

EnemyX = 200
EnemyY = 100


running = True
while running:
    drawBg(background)

    drawPlane(plane, PlaneX, PlaneY)

    drawEnemy(enemy, EnemyX, EnemyY)

    # event handle
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

        #判断键盘事件
        key = pygame.key.get_pressed()
        if key[pygame.K_a] and PlaneX > 0:
            PlaneX -= PlaneSpeed
        elif key[pygame.K_d] and PlaneX + 64 < Screen_Width:
            PlaneX += PlaneSpeed


    # repaint -> update
    pygame.display.update()