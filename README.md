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

## 👤 Muallif

**Abdullojon Farmonov**

**farmonovabdullojon04@gmail.com**
<img width="386" height="854" alt="image" src="https://github.com/user-attachments/assets/fb67426d-e08e-4243-aa56-2d68d8f137a7" />
<img width="720" height="1560" alt="image" src="https://github.com/user-attachments/assets/31812618-1d28-41dd-b028-f2383f48ed25" />
<img width="720" height="1560" alt="image" src="https://github.com/user-attachments/assets/71e5c10f-d533-4b0a-ae16-e8781b4a03d2" />
<img width="720" height="1560" alt="image" src="https://github.com/user-attachments/assets/5ce34378-6004-4b5c-b145-1566a937fc54" />
<img width="720" height="1560" alt="image" src="https://github.com/user-attachments/assets/7f602c66-a9b9-4296-8a9a-2f7c537f7ef3" />
<img width="720" height="1560" alt="image" src="https://github.com/user-attachments/assets/04b86ebf-1cc9-4c78-8f70-27a84c8d3294" />
<img width="720" height="1560" alt="image" src="https://github.com/user-attachments/assets/96e97cfc-c971-4a0a-9068-11f699e45061" />
<img width="720" height="1560" alt="image" src="https://github.com/user-attachments/assets/285b88bf-da13-4259-945e-ed25f1ec3234" />
<img width="720" height="1560" alt="image" src="https://github.com/user-attachments/assets/c6a79f10-36f3-4619-8b2b-e0718fe67417" />
<img width="720" height="1560" alt="image" src="https://github.com/user-attachments/assets/3e4a0fa8-9617-472f-aa2f-434e609845a4" />















