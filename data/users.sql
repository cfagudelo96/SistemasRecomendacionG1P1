PGDMP                         v            SistemasRecomendacion    9.6.3    10.1 
    ]           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            ^           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �            1259    99943    custom_user    TABLE     a   CREATE TABLE custom_user (
    id bigint NOT NULL,
    user_profile_id character varying(255)
);
    DROP TABLE public.custom_user;
       public         SistemasRecomendacion    false            �            1259    99941    custom_user_id_seq    SEQUENCE     t   CREATE SEQUENCE custom_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.custom_user_id_seq;
       public       SistemasRecomendacion    false    189            _           0    0    custom_user_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE custom_user_id_seq OWNED BY custom_user.id;
            public       SistemasRecomendacion    false    188            �           2604    99946    custom_user id    DEFAULT     b   ALTER TABLE ONLY custom_user ALTER COLUMN id SET DEFAULT nextval('custom_user_id_seq'::regclass);
 =   ALTER TABLE public.custom_user ALTER COLUMN id DROP DEFAULT;
       public       SistemasRecomendacion    false    188    189    189            Z          0    99943    custom_user 
   TABLE DATA               3   COPY custom_user (id, user_profile_id) FROM stdin;
    public       SistemasRecomendacion    false    189   H
       `           0    0    custom_user_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('custom_user_id_seq', 992, true);
            public       SistemasRecomendacion    false    188            �           2606    99948    custom_user pk_custom_user 
   CONSTRAINT     Q   ALTER TABLE ONLY custom_user
    ADD CONSTRAINT pk_custom_user PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.custom_user DROP CONSTRAINT pk_custom_user;
       public         SistemasRecomendacion    false    189            �           2606    99950 *   custom_user uq_custom_user_user_profile_id 
   CONSTRAINT     i   ALTER TABLE ONLY custom_user
    ADD CONSTRAINT uq_custom_user_user_profile_id UNIQUE (user_profile_id);
 T   ALTER TABLE ONLY public.custom_user DROP CONSTRAINT uq_custom_user_user_profile_id;
       public         SistemasRecomendacion    false    189            Z      x�M�K��8r ᱵ�H�|�ŀG����IE��5���w$�����������ϧ�{BS<G�yRS>������h�g5���������U��=�z�x^��yU���*��U��ϫ�w�WU�>������㟑����T����;ϧ�/�OU_=���~>U}�|���	U��	U�����u��xBUq�PU���zBU�O�*�	U�>GU��U��9�:�sTu�/JU�<GU'���S�Q�����sTu�IU��IU�����{RUO�*�]U�O�*�IUe?���'U���������}JU�=����TU�)U�����)UU?����TU��������}ZU�=����U��iUu>��f[PU�Ӫ�yZU�Ϩj~Ϩj�gT5�3��xFUs�Q��3��zFU�n���gT5��������}VU�=���gU��YUm>���gU�����MTU{w��X3���G�f6�_hf'��l����^�+�l����n��l���L����o�W���ѿw��N�ޝ^[�{�z�����ٿw��n���^��{�{���qF}l��v|���c���fV���]�5����_��������j�g|�c����fV_\(����j�gͬ>��W �fV�"�5��0���Շ�`ͬ�s%W���5���������4`�O���+X3�^���Y}yj�^���Y}������ÅW0�fV2���5�������W�����������`͏'�A�+#X3�$^)��Y}0��	�����cM}H�
���ÊWX�fVZ��5������Շ��`ͬ���&���`��K���+7X3�8^���Y}�������Wz�fV�ޟ����{��>�̯f~���̡�߼�5sj�W��`�ܚ��+?X3�f��kf���'?X3�?>���Y}������ÏO~�fV�}^��}`������#����3����C����S����c����s����`�#���������F}������ÏO~�fV~|�5������Շ��`ͬ�s��ԇ��`ͬ>���kf���'?X��>���kf���'?X3�/�C������Շ��`ͬ>���kf���'?X3�?>���Y}u�ZՇ��`ͬ>���ksՇ��`ͬ>���kf���'?X3���c������Շ��`ͬ>���kf���'?>���Ǉ�������?_}{�|���'?>|��Ǉ�����>|��ÇO~|��ɏo��]�G\�G�Cȏ���G�Cȏ����!?B~>��|���fD}��#�!�G�Cȏ����!?B~>��|���#�!�G|�Ս����F}��#�!�G�Cȏ����!?B~>����fI~�}�$?�[���rI}�����zI~�}�$?�`�q�0ɏ����G�Cȏ����!?B~Ĺo�ԇ!?B~>��|���#�!�G�Cȏ����!?B~D��s�Ç��!?B~>��|���#�!�G�Cȏ����!?B~��<�x�#� �G��Q��<�x�#� �G�}��><�x�#� �G�Aȏ����!?�牐�!?B~>����o\Շ!?/B~^����x�#�"�G�Eȏ����!?/B~��W��Ë�/B~���8xq�ǹ_����#?^�q��ȏ�G~�8����;k��ő/��8xq����#?^�q��ȏ�G~�8���ő/��8�}��>�8���ő/��8xq����#?^�q��ȏ�G~|8���}˯��=�Ç#?>�q��ȏ�G~|8���Ñ�~���~���~����3����C��~���~���~���~���~����8�p����#?>�q��ȏ��C����ȏ�G~|8���Ñ��8�p����#?>�q��ȏ�G~��_rԇG~|8���Ñ��8xp����端><8������><8�������8xp����#?�q��ȏ�G~<8�����g�.������8xp����#?�q��ȏ�G~<8�������8{?Ʃ��H<8�#��ȏ�ȏ�ȏ�ȏă��)?R~$�����Z�><H��x��#� �G�Aʏă��)?R~$��H<H��x��#��9S}x��#� �G�Aʏă��)?R~$��H�R~$>��H|H��q���R~$>��H|H�����#�!�G�Cʏć��)?R~$>���s?�R~$>��H|H�����#�!�G�Cʏ�_��G����#��j������ȿ/�껟��G�o��#�Gk���������Z~$>��H|H�����#�!�G�Cʏ��I]}u����牔�)?/R~$^��H�'R~$~��H�H�����#�#�G�Gʏ���_}���#�#�G�Gʏď��)??R~$~��H�H�����#�#�G�=��>�H�����#�#�G�Gʏď��)??R~$~��H�H�����#��P~��(�H�Q����#�G�Gʏ�g��G��K���G�Gɏ����:ԇ%?
?J~~��(�(�Q�Q���G�Gɏ��%?
?J~�w��?J~~��(�(�Q�Q���G�Gɏ��%?
?J~~����'cԇ%?
?J~~��(�(�Q�Q���G�Gɏ��%?
?J~ԹGwԇ%?
?J~~��(�(�Q�Q���G�Gɏ��%?
?J~T޳E�Ï��%?
?J~~��(�(�Q�ܓ��{�I~�=�$?�}��w�I}�����{�I~�=�$?�x��%?
/J~^��(�(�QxQ���G�=����Ǳԇ%?
/J~^��(�(�QxQ���G�Eɏ��%?
/J~���b�Ë��%?
/J~^��(�(�QxQ���G�Eɏ��%?j�6��EɏƋ��%?/J~4^��h�(���������h�h��x���ĝ���G�EˏƋ��-?/Z~4^��h�h��x����G�Eˏ��@��EˏƋ��-?/Z~4^��h�h��x����G�EˏƋ��̢���G�EˏƋ��-?/Z~4^��h�h��x����G�Eˏ>�P����G�EˏƋ��-?/Z~4^��h�h��x����G�Eˏ�{�S}x����G�EˏƋ��-?/Z~4^��h�h��x��y�h��u���?Z~4~��h�h������Y���Ȭ��{fV~�=4+?����}��ʏ�;7������'g�Gߣ����G�GˏƏ��-??Z~4~��h�h�������U~��h�h�������G�GˏƏ��-??Z~4~��h�h��{��?Z~~���h�1���c����Gˏ����#?�ޘ��#?�w�F�?F~~����1�1�c�c����ȏ����#??F~~�����V~����1�1�c�c����ȏ����#??F~~����1qO��?F~~����1�1�c�c����ȏ����#??F~~���s���?F~~����1�1�c�c����ȏ����#??F~~������Շ#??F~~����1�1�c�c����ȏ����#??F~L��Ï��#??F~~����1�1�c�c����ȏ����#?������>��1�1�c���1����{�B~̽~!?�޿�s/`ȏ�70���+�c��`��^�#??F~~����1�1�c�c����ȏ����#?f�%���ȏŏ��#??F~,~��X����1�c�c����ʏ�w�����-���ʏŏ��+??V~,~��X�X�����c�c����ʏŏ���k6�Ï��+??V~,~��X�X�����c�c����ʏŏ��+?6�= ���ʏŏ��+??V~,~��X�X�����c�c����ʏŏ�{�E%���ʏŏ��+??V~,~��X�X�����c�c����ʏŏ���&���c����ʏŏ��+??V~,~��X�X�����c�c����ʏ�{�K}���c�c����ʏŏ��+??V~,~��X�X���� �   �c�c����������ԇ+??V~,~��X�X�����c�c����ʏŏ��+??V~���r껷����k{�c�=������{sO~콺'?��ݓ{/�ɏ������]�S^�?~������y��  �]~     