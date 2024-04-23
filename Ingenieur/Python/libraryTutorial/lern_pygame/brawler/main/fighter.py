import pygame

"""

self 调用类中的属性

"""


# for fighters
class Fighter():
    def __init__(self, x, y, flip, data, sprite_sheet, animation_steps):
        self.size = data[0]
        self.scale = data[1]
        self.offset = data[2]
        self.animation_list = self.load_images(sprite_sheet, animation_steps)
        self.flip = flip  # 翻动
        self.rect = pygame.Rect(x, y, 80, 180)
        self.action = 0  # 0:idle 1:run 2:jump 3:attack1 4:attack2 5:hit 6:death
        self.index = 0
        self.image = self.animation_list[self.action][self.index]
        self.update_timer = pygame.time.get_ticks()
        self.vel_y = 0
        self.running = False
        self.jump = False  # 只能跳一次
        self.attack_type = 0
        self.attacking = False  # 只能攻击一次
        self.attack_cooldown = 0
        self.hit = False
        self.health = 100
        self.alive = True

    def load_images(self, sprit_sheet, animation_steps):
        # extract images from spritesheet
        y = 0
        animation_list = []
        for animation in animation_steps:
            temp_img_list = []
            for x in range(animation):
                temp_img = sprit_sheet.subsurface(x * self.size, y * self.size, self.size, self.size)  # 切割成小照片
                temp_img_list.append(pygame.transform.scale(temp_img, (self.size * self.scale, self.size * self.scale)))
            animation_list.append(temp_img_list)
            y += 1
        return animation_list

    def move(self, SCREEN_HEIGHT, SCREEN_WIDTH, surface, target):
        SPEED = 10
        GRAVITY = 2  # 重力
        dx = 0
        dy = 0
        self.running = False
        self.attack_type = 0

        # get keypresses
        key = pygame.key.get_pressed()

        # can only perform other actions if not currently attacking
        if self.attacking == False:

            # movement
            if key[pygame.K_a]:  # left
                dx = -SPEED
                self.running = True
            if key[pygame.K_d]:  # right
                dx = +SPEED
                self.running = True

            # jump
            if key[pygame.K_w] and self.jump == False:
                self.vel_y = -30
                self.jump = True

            # attack
            if key[pygame.K_j] or key[pygame.K_k]:

                self.attack(surface, target)

                # determine which attack type was used
                if key[pygame.K_j]:
                    self.attack_type = 1
                if key[pygame.K_k]:
                    self.attack_type = 2

        # apply gravity
        self.vel_y += GRAVITY
        dy += self.vel_y

        # ensure player stays on the screen
        if self.rect.left + dx < 0:
            dx = -self.rect.left

        if self.rect.right + dx > SCREEN_WIDTH:
            dx = SCREEN_WIDTH - self.rect.right

        if self.rect.bottom + dy > SCREEN_HEIGHT - 110:
            self.vel_y = 0  # 如果又落地
            self.jump = False
            dy = SCREEN_HEIGHT - self.rect.bottom - 110

        # ensure players face each other
        if target.rect.centerx > self.rect.centerx:  # 目标在右边
            self.flip = False
        else:
            self.flip = True

        # apply attack cooldown
        if self.attack_cooldown > 0:
            self.attack_cooldown -= 1

        # update player position
        self.rect.x += dx
        self.rect.y += dy  # 目前还未设置跳跃

    def attack(self, surface, target):
        if self.attack_cooldown == 0:
            self.attacking = True
            # 建立攻击矩形
            if self.flip == False:
                attacking_rect = pygame.Rect(self.rect.centerx, self.rect.y, 2 * self.rect.width, self.rect.height)
            # 类属性中的矩形 x中心点, y不变, 2倍宽度, 高不变
            else:
                attacking_rect = pygame.Rect(self.rect.centerx - 2 * self.rect.width, self.rect.y, 2 * self.rect.width,
                                             self.rect.height)

            # 检测是否造成伤害
            if attacking_rect.colliderect(target.rect):
                target.health -= 10
                target.hit = True
                print(target.health)
            else:
                print("no")

            # pygame.draw.rect(surface, (0, 255, 0), attacking_rect)

    # handle animation updates
    def update(self):
        # check what action the player is performing
        if self.health <= 0:
            self.health = 0
            self.alive = False
            self.update_action(6)
        elif self.hit == True:
            self.update_action(5)
        elif self.attacking == True:
            if self.attack_type == 1:
                self.update_action(3)
            elif self.attack_type == 2:
                self.update_action(4)
        elif self.jump == True:
            self.update_action(2)
        elif self.running == True:
            self.update_action(1)
        else:
            self.update_action(0)

        animation_cooldown = 50

        # update image
        self.image = self.animation_list[self.action][self.index]

        # check if enough time has passed since the last update
        if pygame.time.get_ticks() - self.update_timer > animation_cooldown:
            self.index += 1
            self.update_timer = pygame.time.get_ticks()

            # check if animation has finished
            if self.index == len(self.animation_list[self.action]):

                # check if the player dead then end the animation
                if self.alive == False:
                    self.index = len(self.animation_list[self.action]) - 1
                else:
                    self.index = 0
                # check if an attack was executed
                if self.action == 3 or self.action == 4:
                    self.attacking = False
                    self.attack_cooldown = 20
                if self.action == 5:
                    self.hit = False

                    self.attacking = False
                    self.attack_cooldown = 20

    # 判断行为更改 因为不同行为 照片数不同 可能导致越界
    def update_action(self, new_action):
        if new_action != self.action:
            self.action = new_action
            # update
            self.index = 0
            self.update_timer = pygame.time.get_ticks()
    def draw(self, surface):
        # 左右翻转
        img = pygame.transform.flip(self.image, self.flip, False) # 这个false是代表上下不翻转
        # pygame.draw.rect(surface, (255, 0, 0), self.rect)
        surface.blit(img,
                     (self.rect.x - (self.offset[0] * self.scale), self.rect.y - (self.offset[1] * self.scale)))
