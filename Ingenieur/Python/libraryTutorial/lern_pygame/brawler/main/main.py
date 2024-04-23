import pygame
from fighter import Fighter

# initialize
pygame.init()

# create game window, two initial arguments
SCREEN_WIDTH = 1000
SCREEN_HEIGHT = 600

absolutePath = "/Users/myry/Documents/MyPythonProject/lernLibs/lern_pygame/brawler/pngs/"

screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))  # create window self
pygame.display.set_caption('Brawler')  # create title

# set framerate
clock = pygame.time.Clock()
FPS = 120  # 设置帧率 否则电脑多给力 游戏画面就多给力

# define colors
RED = (255, 0, 0)
YELLOW = (255, 255, 0)
WHITE = (255, 255, 255)

# define fighter variables
WARRIOR_SIZE = 162  # 1620 像素 10 帧 -> 162
WARRIOR_SCALE = 4
WARRIOR_OFFSET = [72, 56]
WARRIOR_DATA = [WARRIOR_SIZE, WARRIOR_SCALE, WARRIOR_OFFSET]
WIZARD_SIZE = 250
WIZARD_SCALE = 3
WIZARD_OFFSET = [112, 107]
WIZARD_DATA = [WIZARD_SIZE, WIZARD_SCALE, WIZARD_OFFSET]

# load background image
bg_image = pygame.image.load(absolutePath + "background.png").convert_alpha()
# convert_alpha() 方法用于将图像转换为适合在游戏中使用的格式，并保留图像的透明度信息

# load spritesheets
warrior_sheet = pygame.image.load(absolutePath + "warrior.png").convert_alpha()
wizard_sheet = pygame.image.load(absolutePath + "wizard.png").convert_alpha()

# define number of steps in each animation
WARRIOR_ANIMATION_STEPS = [10, 8, 1, 7, 7, 3, 7]
WIZARD_ANIMATION_STEPS = [8, 8, 1, 8, 8, 3, 7]


# function for drawing background
def draw_bg():
    # size transform
    scaled_bg = pygame.transform.scale(bg_image, (SCREEN_WIDTH, SCREEN_HEIGHT))
    screen.blit(scaled_bg, (0, 0))


# function for drawing fighter health bars
def draw_health_bars(health, x, y):
    ratio = health / 100
    pygame.draw.rect(screen, WHITE, (x - 1, y - 1, 402, 32))  # 边框
    pygame.draw.rect(screen, RED, (x, y, 400, 30))  # 底色
    pygame.draw.rect(screen, YELLOW, (x, y, 400 * ratio, 30))  # 血条


# create two instances of fighters
fighter_1 = Fighter(200, 310, False, WARRIOR_DATA, warrior_sheet, WARRIOR_ANIMATION_STEPS)
fighter_2 = Fighter(700, 310, True, WIZARD_DATA, wizard_sheet, WIZARD_ANIMATION_STEPS)

# 这样的话 窗口只会亮一下 -> need loop
run = True
while run:
    clock.tick(FPS)

    # draw background
    draw_bg()

    # draw health bars
    draw_health_bars(fighter_1.health, 20, 20)
    draw_health_bars(fighter_2.health, 580, 20)

    # move fighter
    fighter_1.move(SCREEN_HEIGHT, SCREEN_WIDTH, screen, fighter_2)

    fighter_1.update()
    fighter_2.update()

    # draw fighters
    fighter_1.draw(screen)
    fighter_2.draw(screen)

    # 增加一个时间监听来退出循环 event handler
    for event in pygame.event.get():
        if event.type == pygame.QUIT:  # pygame.QUIT 也就是点击叉叉
            run = False

    # update display -> repaint
    pygame.display.update()

# exit pygame
pygame.quit()
