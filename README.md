## 🧠 MemoryGame

**MemoryGame** — Android uchun yozilgan klassik **xotira (memory) kartalar o'yini**. O'yinchi taxtadagi yopiq kartalarni ochib, bir xil rasmli juftliklarni topishi kerak. Uch xil qiyinlik darajasi mavjud bo'lib, taxta hajmi darajaga qarab kattalashib boradi.

### ✨ Xususiyatlari

* 🎮 Klassik memory-card o'yini — taxtadagi yopiq kartalarni ochib, bir xil rasmli juftlarni topish
* 🧩 3 ta qiyinlik darajasi (`LevelEnum`):
  * **Easy** — 3×4 (12 karta / 6 juft)
  * **Medium** — 4×6 (24 karta / 12 juft)
  * **Hard** — 6×8 (48 karta / 24 juft)
* 🎬 Kartalarning paydo bo'lishi, ochilishi va yopilishi uchun 3D flip (rotationY) animatsiyalari
* 🔢 Qadamlar hisoblagichi (**Attempt counter**) — har bir karta ochilganda avtomatik oshib boradi
* 🏅 Level hisoblagichi — har bir topilgan juftlik `Level` ko'rsatkichini oshiradi
* 🏆 G'alaba oynasi (**Finish dialog**) — barcha juftlar topilgach, umumiy level va urinishlar soni bilan chiqadi
* ⏸ O'yin ichi menyu — davom ettirish (Resume), qayta boshlash (Restart) yoki bosh menyuga qaytish (Home)
* 🔁 Qayta boshlash (**Reload**) tugmasi — o'yinni istalgan vaqtda qaytadan boshlash
* 📱 Edge-to-Edge dizayn — zamonaviy, to'liq ekranli interfeys

### 🕹️ Qanday o'ynaladi

1. Bosh ekrandan qiyinlik darajasini (Easy / Medium / Hard) tanlang.
2. Barcha kartalar bir necha soniya ochiq ko'rsatiladi, so'ng avtomatik yopiladi — joylashuvni yodda saqlab qoling.
3. Ikkita kartani ketma-ket bosib oching: agar rasm mos kelsa, ular taxtadan yo'qoladi (juftlik topildi); mos kelmasa, avtomatik qayta yopiladi.
4. Har bir ochilgan karta **Attempt** hisoblagichini oshiradi.
5. Barcha juftlar topilgach, natija oynasida (level va urinishlar soni) chiqadi — **Retry** bilan qayta boshlash yoki **Home** orqali bosh menyuga qaytish mumkin.

### 🛠 Texnologiyalar

| Texnologiya | Tavsif |
|---|---|
| **Kotlin** | Asosiy dasturlash tili |
| **XML (View-based UI)** | Barcha ekranlar (`activity_main`, `screen_level`, `screen_game`, dialoglar) klassik Android **XML layout** fayllarida chizilgan — Jetpack Compose emas |
| **View Binding** (`vbpd`) | UI komponentlarga xavfsiz, boilerplate'siz murojaat |
| **Navigation Component** | `LevelScreen` va `GameScreen` fragmentlari orasida `nav_graph.xml` orqali navigatsiya |
| **RecyclerView** | "About" (info) oynasidagi ma'lumotlar ro'yxatini chiqarish (`InfoAdapter`) |
| **Room** | Lokal ma'lumotlar bazasi uchun tayyorlangan bog'liqlik |
| **Material Components** | UI dizayn elementlari |
| **KSP** | Kotlin Symbol Processing (Room annotatsiyalarini kompilyatsiya qilish uchun) |
| **AndroidX Activity (Edge-to-Edge)** | To'liq ekranli, zamonaviy UI |

### 🏗 Arxitektura

Loyiha **Single-Activity + Fragment** arxitekturasi asosida qurilgan:

```
MainActivity (host)
 └── NavHostFragment (nav_graph.xml)
      ├── LevelScreen   — daraja tanlash, "About" va "Exit" dialoglari
      └── GameScreen    — o'yin maydoni, kartalar mantig'i, menyu va g'alaba dialogi
```

- **MainActivity** — yagona Activity, faqat `NavHostFragment`'ni ushlab turadi va edge-to-edge rejimini yoqadi.
- **Navigation Component** — `LevelScreen` va `GameScreen` orasidagi o'tishlarni `nav_graph.xml` orqali boshqaradi; `Bundle` yordamida tanlangan `LevelEnum` `GameScreen`'ga uzatiladi.
- **UI qatlami (View)** — barcha ekranlar `res/layout/*.xml` fayllarida deklarativ tarzda chizilgan, kod ichida esa **View Binding** orqali (`ScreenGameBinding`, `ScreenLevelBinding` va h.k.) murojaat qilinadi — dinamik `findViewById` chaqiruvlari minimallashtirilgan.
- **Domain qatlami** — `AppRepository` (singleton `object`) statik karta ro'yxatini (`R.drawable.image_1..25`) saqlaydi va tanlangan darajaga mos juftlashgan, aralashtirilgan karta ro'yxatini (`getCardListByLevel`) qaytaradi.
- **Model qatlami** — `CardData` (karta ma'lumoti: id + rasm resursi) va `LevelEnum` (daraja bo'yicha taxta o'lchami: `horizontalCount` x `verticalCount`) oddiy data-model sifatida ajratilgan.
- **Adapter qatlami** — `InfoAdapter` "About" dialogidagi matnli ro'yxatni `RecyclerView` orqali chiqaradi.
- **O'yin mantig'i** — `GameScreen` fragmenti ichida joylashgan: kartalarni dinamik `ImageView` sifatida yaratish, flip-animatsiyalar (`rotationY`), ikkita kartani solishtirish (`isCorrect`), mos kelsa yashirish (`correct`), mos kelmasa qayta yopish (`closeCard`) va g'alaba shartini tekshirish.
## 👤 Muallif

**Abdullojon Farmonov**

**farmonovabdullojon04@gmail.com**
